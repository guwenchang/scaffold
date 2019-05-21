package com.smart.starter.log.event;

import com.smart.starter.log.OpLogParam;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 日志分发事件
 * @author guwenchang
 * @date 2019-04-29 11:51
 */
@Getter
@AllArgsConstructor
public class OpLogEvent {
	private final OpLogParam opLogParam;
}
