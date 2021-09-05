FROM node:14.17.0-alpine AS builder
WORKDIR /app
COPY . .
RUN npm i
RUN npm run build --prod
FROM nginx:1.20.1
WORKDIR /usr/share/nginx/html
RUN rm -rf ./*
COPY --from=builder /app/dist/client .
ENTRYPOINT ["nginx", "-g", "daemon off;"]
