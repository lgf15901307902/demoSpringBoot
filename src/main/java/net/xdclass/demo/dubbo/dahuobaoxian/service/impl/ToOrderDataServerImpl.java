package net.xdclass.demo.dubbo.dahuobaoxian.service.impl;

import org.slf4j.Logger;

 import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import net.xdclass.demo.dubbo.ABRequestDto;
import net.xdclass.demo.dubbo.dahuobaoxian.service.ToOrderDataServer;

@Component
@Service
public class ToOrderDataServerImpl implements ToOrderDataServer{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String togetDecryptDataPathAtom(ABRequestDto abRequestDto) {
	 	
		String resultXml="dubbo";
	 
		logger.info(resultXml);
		return resultXml;
	}
}
