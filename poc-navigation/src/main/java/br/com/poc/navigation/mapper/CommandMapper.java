package br.com.poc.navigation.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.poc.navigation.comand.impl.CommandFactory;
import br.com.poc.navigation.exception.ParseInputCommandException;

/**
 *
 * @author wpadua
 */
@Component
public interface CommandMapper {

	List<CommandFactory> parse(String sequentialCommands)
			throws ParseInputCommandException;

}