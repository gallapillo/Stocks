package com.gallapillo.stocks.utils

sealed class Screen(val route: String) {
    object CompanyList : Screen("company_list")
}
