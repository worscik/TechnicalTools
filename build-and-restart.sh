docker build -t creator .
docker stop creator || true
docker rm creator || true
docker run -d -p 80:80 --name creator creator