/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.product.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.product.model.CPDefinitionOptionRel;
import com.liferay.commerce.product.service.CPDefinitionOptionRelLocalServiceUtil;

/**
 * The extended model base implementation for the CPDefinitionOptionRel service. Represents a row in the &quot;CPDefinitionOptionRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDefinitionOptionRelImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPDefinitionOptionRelImpl
 * @see CPDefinitionOptionRel
 * @generated
 */
@ProviderType
public abstract class CPDefinitionOptionRelBaseImpl
	extends CPDefinitionOptionRelModelImpl implements CPDefinitionOptionRel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp definition option rel model instance should use the {@link CPDefinitionOptionRel} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CPDefinitionOptionRelLocalServiceUtil.addCPDefinitionOptionRel(this);
		}
		else {
			CPDefinitionOptionRelLocalServiceUtil.updateCPDefinitionOptionRel(this);
		}
	}
}