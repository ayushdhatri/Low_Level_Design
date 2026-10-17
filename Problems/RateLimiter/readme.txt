"You're building an in-memory rate limiter for an API gateway.
The system receives configuration from an external service that provides rate limiting rules
per endpoint. Each endpoint can have its own limit with a specific algorithm. 
Here's an example configuration for one endpoint:
{
  "endpoint": "/search",
  "algorithm": "TokenBucket",
  "algoConfig": {
    "capacity": 1000,
    "refillRatePerSecond": 10
  }
}
Lets understand what they are trying to say
// so for each endpoint we  have different configurations:
// each congiruations gives us information about algorithms 
// algoConfig rules which defines the parameter of the algorithm

    












