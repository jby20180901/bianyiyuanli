FROM gcc:10
WORKDIR /app/
COPY ./* ./
RUN gcc 编译作业.cpp -o program
RUN chmod +x program