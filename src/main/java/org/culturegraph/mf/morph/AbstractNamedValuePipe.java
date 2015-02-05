/*
 *  Copyright 2013, 2014 Deutsche Nationalbibliothek
 *
 *  Licensed under the Apache License, Version 2.0 the "License";
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.culturegraph.mf.morph;

import org.culturegraph.mf.util.xml.Location;

/**
 * Base class for {@link NamedValuePipe}s.
 *
 * @author Markus Michael Geipel
 * @author Chistoph Böhme
 *
 */
public abstract class AbstractNamedValuePipe implements NamedValuePipe {

	private NamedValueReceiver namedValueReceiver;

	private Location sourceLocation;

	@Override
	public final void setNamedValueReceiver(final NamedValueReceiver receiver) {
		namedValueReceiver = receiver;
	}

	@Override
	public final void addNamedValueSource(final NamedValueSource source) {

		source.setNamedValueReceiver(this);
		onNamedValueSourceAdded(source);
	}

	protected final NamedValueReceiver getNamedValueReceiver() {
		return namedValueReceiver;
	}

	@Override
	public final void setSourceLocation(final Location sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	@Override
	public final Location getSourceLocation() {
		return sourceLocation;
	}

	protected void onNamedValueSourceAdded(
			final NamedValueSource namedValueSource) {
		// Default implementation does nothing
	}

}
