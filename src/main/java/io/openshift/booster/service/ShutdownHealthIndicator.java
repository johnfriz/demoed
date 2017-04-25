/*
 * Copyright 2016-2017 Red Hat, Inc, and individual contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.openshift.booster.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
@Component
public class ShutdownHealthIndicator implements HealthIndicator {

	private volatile boolean shutdown;

	@Override
	public Health health() {
		return shutdown ? Health.down().withDetail("shutdown", true).build() : Health.up().build();
	}

	void shutdown() {
		this.shutdown = true;
	}
}
