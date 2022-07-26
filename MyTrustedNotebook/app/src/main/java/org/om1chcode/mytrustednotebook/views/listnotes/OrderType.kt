package org.om1chcode.mytrustednotebook.views.listnotes

sealed class OrderType
{
	object Ascending : OrderType()
	object Descending : OrderType()
}