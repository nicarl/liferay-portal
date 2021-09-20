/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.search.experiences.blueprint.parameter;

import com.liferay.petra.string.StringBundler;


import com.liferay.search.experiences.blueprint.parameter.exception.SXPParameterException;

import java.util.Map;

/**
 * @author Petteri Karttunen
 */
public class BooleanSXPParameter extends BaseSXPParameter {

	public BooleanSXPParameter(
		String name, boolean templateVariable, Boolean value) {

		super(name, templateVariable);

		_value = value;
	}

	@Override
	public boolean accept(EvaluationVisitor visitor)
		throws SXPParameterException {

		return visitor.visit(this);
	}

	@Override
	public String accept(ToStringVisitor visitor, Map<String, String> options)
		throws Exception {

		return visitor.visit(this, options);
	}

	public Boolean getValue() {
		return _value;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("BooleanSXPParameter [_name=");
		sb.append(name);
		sb.append(", _templateVariable=");
		sb.append(templateVariable);
		sb.append(", _value=");
		sb.append(_value);
		sb.append("]");

		return sb.toString();
	}

	private final Boolean _value;

}