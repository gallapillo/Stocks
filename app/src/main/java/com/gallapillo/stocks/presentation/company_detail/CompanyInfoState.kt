package com.gallapillo.stocks.presentation.company_detail

import com.gallapillo.stocks.domain.model.CompanyInfo
import com.gallapillo.stocks.domain.model.IntradayInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
