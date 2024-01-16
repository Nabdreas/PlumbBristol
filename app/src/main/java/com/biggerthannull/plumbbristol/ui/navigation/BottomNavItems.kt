package com.biggerthannull.plumbbristol.ui.navigation

import com.biggerthannull.plumbbristol.ui.navigation.models.BottomNavPaths

sealed class BottomNavItems(var title: String, var path: String)  {
    data object Home: BottomNavItems("Bathrooms", BottomNavPaths.HOME)
    data object Services: BottomNavItems("Services", BottomNavPaths.SERVICES)
    data object ContactUs: BottomNavItems("Contact us", BottomNavPaths.CONTACT_US)

}