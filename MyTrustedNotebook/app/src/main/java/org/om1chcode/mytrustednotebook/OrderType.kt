package org.om1chcode.mytrustednotebook

sealed class OrderType
{
	object Ascending : OrderType()
	object Descending : OrderType()
}