docker build -t technicalsite .
docker stop technicalsite || true
docker rm technicalsite || true
docker run -d -p 80:8080 --name technicalsite technicalsite