mvn clean package
docker compose rm -f
docker compose build --no-cache
docker compose up ibmmq &
sleep 10
docker compose up web