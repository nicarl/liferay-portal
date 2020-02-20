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

import React, {useEffect, useMemo, useRef, useState} from 'react';

import DndProvider from './DndProvider';
import MillerColumnsColumn from './MillerColumnsColumn';

const cache = {};

const massageColumns = columns => {
	const newColumns = [];
	let newColumn;
	let parent;

	for (let i = 0; i < columns.length; i++) {
		const columnItems = columns[i];

		newColumn = {
			items: [],
			parent
		};

		let newParent;

		columnItems.forEach(columnItem => {
			const newColumnItem = {
				...columnItem,
				columnId: i,
				parent
			};

			if (newColumnItem.active) {
				newParent = newColumnItem;
			}

			newColumn.items.push(newColumnItem);
			cache[newColumnItem.id] = newColumnItem;
		});

		if (parent && parent.active) {
			parent.child = newColumn.items;
		}

		parent = newParent;

		newColumns.push(newColumn);
	}

	if (parent && parent.active) {
		parent.child = newColumn.items;
	}

	return newColumns;
};

const noop = () => {};

const MillerColumns = ({
	actionHandlers,
	initialColumns = [],
	namespace,
	onColumnsChange = noop,
	onItemMove = noop
}) => {
	const rowRef = useRef();

	const massagedColumns = useMemo(() => massageColumns(initialColumns), [
		initialColumns
	]);

	const [columns, setColumns] = useState(massagedColumns);

	const columnsRef = useRef(columns);

	useEffect(() => {
		if (rowRef.current) {
			rowRef.current.scrollLeft = rowRef.current.scrollWidth;
		}
	}, []);

	useEffect(() => {
		if (columns !== columnsRef.current) {
			onColumnsChange(columns);
			columnsRef.current = columns;
		}
	}, [columns, onColumnsChange]);

	const getItem = itemId => {
		return cache[itemId];
	};

	const onItemDrop = (sourceItemId, parentItemId, order) => {
		const newColumns = [...columns];

		const sourceItem = getItem(sourceItemId);

		let parentItem;
		if (parentItemId) {
			parentItem = getItem(parentItemId);
		}
		else {
			parentItem = newColumns[newColumns.length - 2].find(
				item => item.active
			);
		}

		//Remove
		sourceItem.parent.child.splice(
			sourceItem.parent.child.indexOf(sourceItem),
			1
		);
		sourceItem.parent.hasChild = !!sourceItem.parent.child.length;

		//Clean child and columns
		if (sourceItem.active && sourceItem.parent !== parentItem) {
			newColumns.splice(sourceItem.columnId + 1, newColumns.length);
		}
		sourceItem.active =
			sourceItem.active && sourceItem.parent === parentItem;

		//Add
		if (parentItem.active) {
			sourceItem.parent = parentItem;
			sourceItem.columnId = parentItem.columnId + 1;
			parentItem.child.splice(order, 0, sourceItem);
			parentItem.hasChild = !!parentItem.child.length;
		}

		//Update
		setColumns(newColumns);
		onItemMove(sourceItem, parentItem, order);
	};

	return (
		<DndProvider>
			<div className="bg-white miller-columns-row" ref={rowRef}>
				{columns.map((column, index) => (
					<MillerColumnsColumn
						actionHandlers={actionHandlers}
						items={column.items}
						key={index}
						namespace={namespace}
						onItemDrop={onItemDrop}
						parent={column.parent}
					/>
				))}
			</div>
		</DndProvider>
	);
};

export default MillerColumns;
