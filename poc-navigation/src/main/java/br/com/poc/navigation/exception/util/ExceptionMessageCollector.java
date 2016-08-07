/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.exception.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wpadua
 */
public class ExceptionMessageCollector {

	public ExceptionMessageCollector() {

	}

	public static List<String> getStackMessages(final Throwable throwable) {

		List<String> messages = new ArrayList<>();

		if (throwable != null && throwable.getMessage() != null) {

			boolean hasNext = true;

			Throwable thr = throwable;

			while (hasNext) {

				messages.add(thr.getMessage());

				hasNext = thr.getCause() != null;

				if (hasNext) {

					thr = thr.getCause();

				}

			}

			messages = formatStackMessages(messages);

		}

		return messages;

	}

	private static List<String> formatStackMessages(List<String> stackMessages) {

		List<String> stackMessagesFormated = new ArrayList<>();

		if (stackMessages != null) {

			for (int i = 0; i < stackMessages.size(); i++) {

				int iDisplay = i + 1;

				stackMessagesFormated.add("[" + iDisplay + "] "
						+ stackMessages.get(i));

			}

		}

		return stackMessagesFormated;

	}

}
