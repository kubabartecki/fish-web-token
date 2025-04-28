FROM node:20-alpine

WORKDIR /

COPY ./public ./public
COPY ./package*.json ./

RUN npm ci

COPY ./src ./src

CMD ["npm", "run", "start"]