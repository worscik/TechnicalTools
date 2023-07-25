docker build -t creator .
docker stop creator || true
docker rm creator || true
docker run -d -p 8080:8080 --name creator creator