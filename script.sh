for i in {1..100}; do
    curl -i http://localhost:8000/health/api/getall
    sleep .01  # Adjust this delay based on your replenishRate
done