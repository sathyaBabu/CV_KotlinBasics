package Class

sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

// This will be viewmodel receives the data from server, sends the state to the user Main
fun processResult(result: Result) {
    when (result) {
        is Result.Loading -> println("Loading...")
        is Result.Success -> println("Success: ${result.data}")
        is Result.Error -> println("Error: ${result.message}")

    }
}

fun main() {
    val successResult = Result.Success("Data fetched successfully")
    val errorResult = Result.Error("Failed to fetch data")
    val loadingResult = Result.Loading

    processResult(loadingResult) // Output: Loading...
    processResult(successResult) // Output: Success: Data fetched successfully
    processResult(errorResult)   // Output: Error: Failed to fetch data

}
/*
Loading...
Success: Data fetched successfully
Error: Failed to fetch data

Process finished with exit code 0
 */