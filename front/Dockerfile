FROM node:12 as builder
WORKDIR /app
COPY package*.json ./
#COPY ["package.json", "package-lock.json", "./"]
#COPY . .
RUN npm install
COPY . .
#RUN npm run build
#RUN npm run dev
EXPOSE 3000
CMD ["npm", "run", "dev"]

#RUN npm run build

#FROM nginx
#RUN rm -rf /etc/nginx/conf.d/default.conf
#COPY --from=builder /app/default.conf /etc/nginx/conf.d/default.conf

#RUN rm -rf /usr/share/nginx/html/*
#COPY --from=builder /app/dist /usr/share/nginx/html


#CMD ["npm", "run", "dev"]
#CMD ["nginx", "-g", "daemon off;"]
