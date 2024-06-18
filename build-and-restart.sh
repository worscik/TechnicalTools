docker build -t tssite .
docker stop tssite || true
docker rm tssite || true
docker run -d -p 80:8080 --name tssite tssite