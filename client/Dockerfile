FROM node:14.17.0-alpine as build-step
RUN mkdir -p /app
WORKDIR /app
COPY package.json /app
RUN npm ci
COPY . /app
RUN npm run build --if-present

FROM nginx:1.20.1
COPY --from=build-step /app/dist/client /usr/share/nginx/html
EXPOSE 80
