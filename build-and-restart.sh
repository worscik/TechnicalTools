docker build -t technicalsite1 .
docker stop technicalsite1 || true
docker rm technicalsite1 || true
docker run -d -p 80:8080 --name technicalsite1 technicalsite1