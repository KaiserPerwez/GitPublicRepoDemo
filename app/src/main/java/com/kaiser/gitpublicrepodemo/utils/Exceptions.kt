package com.kaiser.gitpublicrepodemo.utils

import java.io.IOException

class ApiException(errorMessage: String) : IOException(errorMessage)
class NoInternetException(errorMessage: String) : IOException(errorMessage)