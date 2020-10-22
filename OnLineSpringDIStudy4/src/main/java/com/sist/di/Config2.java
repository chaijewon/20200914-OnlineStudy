package com.sist.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {
  @Bean("mem")
  public Member memberInfo()
  {
	  Member m=new Member();
	  m.setName("√·«‚¿Ã");
	  m.setAddr("º≠øÔ");
	  m.setTel("010-1111-1111");
	  return m;
  }
}
