FROM gcc:10
WORKDIR /app/
COPY ./* ./
RUN gcc firstwork.c -o -lm program
RUN chmod +x program
