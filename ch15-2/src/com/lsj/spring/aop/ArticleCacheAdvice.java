package com.lsj.spring.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

import com.lsj.spring.model.Article;

//Around Advice 실습용 캐시 서비스를 제공할 Advice클래스
public class ArticleCacheAdvice {
	private Map<Integer, Article> cache = new HashMap<Integer, Article>();
	
	public Article cache(ProceedingJoinPoint joinPoint) throws Throwable{
		//대상 메서드 실행 전 끼어들어 실행할 로직을 작성할 수 있다.
		Integer id = (Integer) joinPoint.getArgs()[0];
		Article article = cache.get(id);
		
		if(article != null){
			System.out.println("[ACA] 캐시에서 Article[" + id + "] 구함");
			return article;
		}
		
		Article ret = (Article) joinPoint.proceed();
		
		//대상 메서드 실행 후 끼어들어 실행할 로직을 작성, 리턴 값을 가공할 수 있다.
		if(ret != null){
			cache.put(id, ret);
			System.out.println("[ACA] 캐시에 Article[" + id + "] 추가함");
		}
		return ret;
	}
}
