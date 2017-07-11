/**
 * 
 */
package com.micmiu.thrift.demo.common;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TTransport;
/*import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author sunyue7
 *
 */
@Component
//@Aspect
public class DemoAspect {

	private static final Logger LOG = LoggerFactory.getLogger("ASPECT");

	public static DemoAspect aspectOf() {
		System.out.println("Aspect of called");
		return new DemoAspect();
	}

	/*@Pointcut("execution(* org.apache.thrift.protocol..*.*(..))")
	//@Pointcut("execution(* com.micmiu.thrift.demo.*.*(..))")
	//@Pointcut("execution(* *.*(..))")
	public void service() {

	}

	@Around("service()")
	public Object serviceAround(ProceedingJoinPoint jp) throws Throwable {
		Object result = null;
		try {
			LOG.error(jp.getSignature().toString());
			Object target = jp.getTarget();
			if(target instanceof TBinaryProtocol && jp.getSignature().getName().equals("writeMessageEnd")) {
				TBinaryProtocol p = (TBinaryProtocol) target;
				p.writeI64(123L);
			}
			if(target instanceof TBinaryProtocol && jp.getSignature().getName().startsWith("read")) {
				TBinaryProtocol p = (TBinaryProtocol) target;
				TTransport t = p.getTransport();
				LOG.error("READ: "+p.readI64());
			}
			if(target instanceof TBinaryProtocol && jp.getSignature().getName().equals("readMessageEnd")) {
				TBinaryProtocol p = (TBinaryProtocol) target;
				long a = p.readI64();
				LOG.error("READ: " + a);
			}
			result = jp.proceed();
		} catch (Throwable e) {
			throw e;
		} finally {

		}
		return result;
	}*/

}
