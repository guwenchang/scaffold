package com.smart.generator;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.toolkit.PackageHelper;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.smart.generator.config.ColumnEntity;
import com.smart.generator.config.IDbQuery;
import com.smart.generator.config.TableEntity;
import com.smart.generator.param.DataSourceParam;
import com.smart.generator.param.GeneratorParam;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author guwenchang
 * @date 2019-05-22
 */
public class GeneratorMain {

	public static void main(String[] args) {
		GeneratorParam param = new GeneratorParam();
		param.setOutPath("/Users/guwenchang/code/codetmp/scaffold/");
		param.setAuthor("guwenchang");
		param.setPackageName("com.smart.log");
		param.setTablePrefix("t_");
		param.setModuleName("center");
		param.setIncludeTables(new String[]{});
		DataSourceParam dataSourceParam = new DataSourceParam();
		dataSourceParam.setDriverName("com.mysql.jdbc.Driver");
		dataSourceParam.setUrl("jdbc:mysql://localhost:3306/scaffold?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false");
		dataSourceParam.setUsername("root");
		dataSourceParam.setPassword("root");
		param.setDataSourceParam(dataSourceParam);
		generate(param);

	}

	private static final String ENTITY_JAVA_VM = "Entity.java.vm";
	private static final String PARAM_JAVA_VM = "Param.java.vm";
	private static final String QUERY_JAVA_VM = "Query.java.vm";
	private static final String RESULT_JAVA_VM = "Result.java.vm";
	private static final String MAPPER_JAVA_VM = "Mapper.java.vm";
	private static final String SERVICE_JAVA_VM = "Service.java.vm";
	private static final String SERVICE_IMPL_JAVA_VM = "ServiceImpl.java.vm";
	private static final String CONTROLLER_JAVA_VM = "Controller.java.vm";
	private static final String MAPPER_XML_VM = "Mapper.xml.vm";

	private static List<String> getTemplates() {
		List<String> templates = new ArrayList<>();
		templates.add("template/Entity.java.vm");
		templates.add("template/Param.java.vm");
		templates.add("template/Query.java.vm");
		templates.add("template/Result.java.vm");
		templates.add("template/Mapper.java.vm");
		templates.add("template/Mapper.xml.vm");
		templates.add("template/Service.java.vm");
		templates.add("template/ServiceImpl.java.vm");
		templates.add("template/Controller.java.vm");
		return templates;
	}



	private static void generate(GeneratorParam param) {
		Connection conn = param.getDataSourceParam().getConn();
		IDbQuery dbQuery = param.getDataSourceParam().getDbQuery();
		Configuration config = getConfig();
		String[] includeTables = param.getIncludeTables();
		PreparedStatement preparedStatement = null;
		ArrayList<Map<String, Object>> tableInfos = Lists.newArrayList();
		try {
			preparedStatement = conn.prepareStatement(dbQuery.tablesSql());
			ResultSet results = preparedStatement.executeQuery();
			ArrayList<TableEntity> tableEntities = Lists.newArrayList();
			while (results.next()) {
				String tableName = results.getString(dbQuery.tableName());
				if (StringUtils.isNotEmpty(tableName)) {
					String tableComment = results.getString(dbQuery.tableComment());
					if ("VIEW".equals(tableComment)) {
						// 跳过视图
						continue;
					}
					TableEntity tableEntity = new TableEntity();
					tableEntity.setTableName(tableName);
					tableEntity.setComments(tableComment);
					String lowClassName = getClassName(tableEntity.getTableName(), param.getTablePrefix());
					String className = capitalFirst(lowClassName);
					tableEntity.setLowerClassName(lowClassName);
					tableEntity.setCaseClassName(className);
					tableEntity.setLowerEntityName(lowClassName+"Entity");
					tableEntity.setCaseEntityName(className+"Entity");
					tableEntity.setLowerParamName(lowClassName+"Param");
					tableEntity.setCaseParamName(className+"Param");
					tableEntity.setLowerQueryParamName(lowClassName+"QueryParam");
					tableEntity.setCaseQueryParamName(className+"QueryParam");
					tableEntity.setLowerResultName(lowClassName+"Result");
					tableEntity.setCaseResultName(className+"Result");
					if ( includeTables != null && includeTables.length > 0) {
						for (String includeTable : includeTables) {
							if (includeTable.equalsIgnoreCase(tableName)){
								tableEntities.add(tableEntity);
							}
						}
					}else {
						tableEntities.add(tableEntity);
					}
				} else {
					System.err.println("当前数据库为空！！！");
				}
			}
			tableEntities.forEach(tableEntity -> tableInfos.add(convertFields(tableEntity,conn,dbQuery,config,param)));
			//生成模板
			System.out.println("开始生成");
			outBatch(tableInfos,param);
			System.out.println("生成完毕");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			// 释放资源
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

	private static void outBatch(ArrayList<Map<String, Object>> tableInfos, GeneratorParam param) {
		//设置velocity资源加载器
		Properties prop = new Properties();
		prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.init(prop);
		List<String> templates = getTemplates();
		for (Map<String, Object> tableInfo : tableInfos) {
			for (String template : templates) {
				Template tpl = Velocity.getTemplate(template, "UTF-8");
				VelocityContext context = new VelocityContext(tableInfo);
				String path =param.getOutPath() + getFileName(template, tableInfo);
				createDir(path);
				PrintWriter writer = null;
				try {
					writer = new PrintWriter(path);
					tpl.merge(context, writer);
					writer.flush();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					writer.close();
				}
			}
		}



	}

	private static Map<String, Object> convertFields(TableEntity tableEntity, Connection conn, IDbQuery dbQuery, Configuration config, GeneratorParam param) {
		List<ColumnEntity> columnEntities = Lists.newArrayList();
		PreparedStatement preparedStatement = null;
		boolean hasBigDecimal = false;
		Map<String, Object> tableInfo = Maps.newHashMap();
		try {
			String tableFieldsSql = dbQuery.tableFieldsSql();
			tableFieldsSql = String.format(tableFieldsSql, tableEntity.getTableName());
			preparedStatement = conn.prepareStatement(tableFieldsSql);
			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {
				ColumnEntity columnEntity = new ColumnEntity();
				columnEntity.setColumnName(results.getString(dbQuery.fieldName()));
				columnEntity.setComments(results.getString(dbQuery.fieldComment()));
				columnEntity.setDataType(getDataType(results.getString(dbQuery.fieldType())));
				columnEntity.setCaseAttrName(capitalFirst(underlineToCamel(columnEntity.getColumnName())));
				columnEntity.setLowerAttrName(underlineToCamel(columnEntity.getColumnName()));
				String key = results.getString(dbQuery.fieldKey());
				boolean idFlag = StringUtils.isNotEmpty(key) && "PRI".equals(key.toUpperCase());
				columnEntity.setIdFlag(idFlag);
				if (idFlag){
					tableEntity.setPk(columnEntity);
				}
				if (dbQuery.isKeyIdentity(results)){
					columnEntity.setIdType(1);
				}else {
					columnEntity.setIdType(2);
				}
				String attrType = config.getString(columnEntity.getDataType(), "unknowType");
				columnEntity.setAttrType(attrType);
				columnEntity.setAttrType(attrType);
				if (!hasBigDecimal && "BigDecimal".equals(attrType)) {
					hasBigDecimal = true;
				}
				columnEntities.add(columnEntity);
				tableEntity.setColumns(columnEntities);
				tableInfo.put("tableName", tableEntity.getTableName());
				tableInfo.put("pk", tableEntity.getPk());
				tableInfo.put("className", tableEntity.getCaseClassName());
				tableInfo.put("classname", tableEntity.getLowerClassName());
				tableInfo.put("entityName", tableEntity.getCaseEntityName());
				tableInfo.put("lowEntityName", tableEntity.getLowerEntityName());
				tableInfo.put("paramName", tableEntity.getCaseParamName());
				tableInfo.put("lowParamName", tableEntity.getLowerParamName());
				tableInfo.put("queryParamName", tableEntity.getCaseQueryParamName());
				tableInfo.put("lowQueryParamName", tableEntity.getLowerQueryParamName());

				tableInfo.put("resultName", tableEntity.getCaseResultName());
				tableInfo.put("lowResultName", tableEntity.getLowerResultName());
				tableInfo.put("pathName", tableEntity.getLowerClassName().toLowerCase());
				tableInfo.put("columns", tableEntity.getColumns());
				tableInfo.put("hasBigDecimal", hasBigDecimal);
				tableInfo.put("datetime", DateUtil.now());
				tableInfo.put("comments", tableEntity.getComments());
				tableInfo.put("author", param.getAuthor());
				tableInfo.put("moduleName", param.getModuleName());
				tableInfo.put("package", param.getPackageName());
				tableInfo.put("mainPath", param.getPackageName());
			}
			tableEntity.setColumns(columnEntities);
		} catch (SQLException e) {
			System.err.println("SQL Exception：" + e.getMessage());
		}
		finally {
			// 释放资源
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tableInfo;
	}

		/**
	 * 获取配置信息
	 */
	private static Configuration getConfig() {
		try {
			return new PropertiesConfiguration("generator.properties");
		} catch (ConfigurationException e) {
			throw new RuntimeException("获取配置文件失败，", e);
		}
	}




	public static String underlineToCamel(String name) {
		// 快速检查
		if (StringUtils.isEmpty(name)) {
			// 没必要转换
			return StringPool.EMPTY;
		}
		String tempName = name;
		// 大写数字下划线组成转为小写 , 允许混合模式转为小写
		if (StringUtils.isCapitalMode(name) || StringUtils.isMixedMode(name)) {
			tempName = name.toLowerCase();
		}
		StringBuilder result = new StringBuilder();
		// 用下划线将原始字符串分割
		String[] camels = tempName.split(ConstVal.UNDERLINE);
		// 跳过原始字符串中开头、结尾的下换线或双重下划线
		// 处理真正的驼峰片段
		Arrays.stream(camels).filter(camel -> !StringUtils.isEmpty(camel)).forEach(camel -> {
			if (result.length() == 0) {
				// 第一个驼峰片段，全部字母都小写
				result.append(camel);
			} else {
				// 其他的驼峰片段，首字母大写
				result.append(capitalFirst(camel));
			}
		});
		return result.toString();
	}

	public static String getClassName(String name,String prefix) {
		if (StringUtils.isNotEmpty(name)) {
			return underlineToCamel(removePrefix(name,prefix));
		}
		return StringPool.EMPTY;
	}

	public static String removePrefix(String name, String prefix) {
		if (StringUtils.isEmpty(name)) {
			return StringPool.EMPTY;
		}
		if (StringUtils.isNotEmpty(prefix)) {
			return name.replace(prefix,"");
		}
		return name;
	}

	public static String capitalFirst(String name) {
		if (StringUtils.isNotEmpty(name)) {
			return name.substring(0, 1).toUpperCase() + name.substring(1);
		}
		return StringPool.EMPTY;
	}

	public static String getDataType(String type) {
		if (StringUtils.isNotEmpty(type)) {
			return type.replaceAll("\\([^)]*\\)", "");
		}
		return StringPool.EMPTY;
	}


	protected static void createDir(String filePath) {
		File file = new File(filePath);
		boolean exist = file.exists();
		if (!exist) {
			PackageHelper.mkDir(file.getParentFile());
		}
	}


	private static String getFileName(String template, Map<String, Object> tableInfo) {
		String className = tableInfo.get("className" ).toString();
		String entityName = tableInfo.get("entityName" ).toString();
		String paramName = tableInfo.get("paramName" ).toString();
		String queryParamName = tableInfo.get("queryParamName" ).toString();
		String resultName = tableInfo.get("resultName" ).toString();
		String packageName = tableInfo.get("package" ).toString();
		String moduleName = tableInfo.get("moduleName" ).toString();

		String packagePath = "";

		if (org.apache.commons.lang.StringUtils.isNotBlank(packageName)) {
			packagePath += packageName.replace(".", File.separator) + File.separator + moduleName + File.separator;
		}

		if (template.contains(ENTITY_JAVA_VM)) {
			return packagePath + "entity" + File.separator + entityName + ".java";
		}
		if (template.contains(PARAM_JAVA_VM)) {
			return packagePath + "param" + File.separator + paramName + ".java";
		}
		if (template.contains(QUERY_JAVA_VM)) {
			return packagePath + "param" + File.separator + queryParamName + ".java";
		}
		if (template.contains(RESULT_JAVA_VM)) {
			return packagePath + "result" + File.separator + resultName + ".java";
		}

		if (template.contains(MAPPER_JAVA_VM)) {
			return packagePath + "mapper" + File.separator + className + "Mapper.java";
		}

		if (template.contains(SERVICE_JAVA_VM)) {
			return packagePath + "service" + File.separator + className + "Service.java";
		}

		if (template.contains(SERVICE_IMPL_JAVA_VM)) {
			return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
		}

		if (template.contains(CONTROLLER_JAVA_VM)) {
			return packagePath + "controller" + File.separator + className + "Controller.java";
		}

		if (template.contains(MAPPER_XML_VM)) {
			return packagePath + "mapper" + File.separator + "xml" + File.separator + className + "Mapper.xml";
		}

		return null;
	}
}
