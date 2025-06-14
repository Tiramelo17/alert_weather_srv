#!/bin/bash
set -e

# Starta MySQL em background
mysqld &

# Espera MySQL subir
echo "Aguardando MySQL iniciar..."
until mysqladmin ping --silent; do
  sleep 2
done

# Cria banco e usuário, se necessário
mysql -uroot -e "CREATE DATABASE IF NOT EXISTS weather_db;"

# Starta a aplicação Java
exec java -jar app.jar
