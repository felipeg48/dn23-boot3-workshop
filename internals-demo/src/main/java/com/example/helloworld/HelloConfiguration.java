package com.example.helloworld;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class HelloConfiguration {

	@Bean
	HelloMessageProvider messageProvider(HelloNameProvider nameProvider) {
		return new HelloMessageProvider(nameProvider);
	}

	@Bean
	static HelloPostProcessor postProcessor() {
		return new HelloPostProcessor();
	}

	static class HelloPostProcessor implements BeanDefinitionRegistryPostProcessor {

		@Override
		public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
			RootBeanDefinition beanDefinition = new RootBeanDefinition(HelloNameProvider.class);
			beanDefinition.setInstanceSupplier(HelloNameProvider::new);
			registry.registerBeanDefinition("nameProvider", beanDefinition);
		}

		@Override
		public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
			// noop
		}

	}

}
