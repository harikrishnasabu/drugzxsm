package com.pms.drugzsm.datamodels.api

data class Supplier(
    val address: String,
    val contactNo: Int,
    val email: String,
    val license: String,
    val supplierName: String
)