FROM gcc:10
WORKDIR /app/
COPY ./* ./
RUN gcc firstwork.c -o program
RUN chmod +x program
