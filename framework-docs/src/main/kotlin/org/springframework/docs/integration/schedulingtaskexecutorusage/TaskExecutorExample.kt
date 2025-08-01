/*
 * Copyright 2002-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.docs.integration.schedulingtaskexecutorusage

import org.springframework.core.task.TaskExecutor

// tag::snippet[]
class TaskExecutorExample(private val taskExecutor: TaskExecutor) {

	private inner class MessagePrinterTask(private val message: String) : Runnable {
		override fun run() {
			println(message)
		}
	}

	fun printMessages() {
		for (i in 0..24) {
			taskExecutor.execute(
				MessagePrinterTask(
					"Message$i"
				)
			)
		}
	}
}
// end::snippet[]