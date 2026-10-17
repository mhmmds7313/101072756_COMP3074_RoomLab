package com.example.roomcustomerapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomcustomerapp.data.Customer
import com.example.roomcustomerapp.data.CustomerDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CustomerViewModel(private val customerDao: CustomerDao) : ViewModel() {
    
    val customers: Flow<List<Customer>> = customerDao.getAllCustomers()

    fun addCustomer(name: String, age: Int, isActive: Boolean) {
        viewModelScope.launch {
            customerDao.insert(Customer(name = name, age = age, isActive = isActive))
        }
    }

    fun deleteCustomer(customer: Customer) {
        viewModelScope.launch {
            customerDao.delete(customer)
        }
    }
}
