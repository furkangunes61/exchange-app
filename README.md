# Exchange Rate API

Spring Boot ile geliştirilmiş döviz kuru dönüştürme servisi.

## 🚀 Özellikler

- Döviz çevirme (USD → TRY, EUR → USD vb.)
- Güncel kurları listeleme
- 160+ para birimini destekleme

## 🛠️ Kullanılan Teknolojiler

- Spring Boot 3.x
- Java 17
- RestTemplate
- Lombok
- ExchangeRate-API

## 📦 Kurulum
```bash
# Projeyi klonla
git clone https://github.com/furkangunes61/exchange-app.git

# Proje dizinine gir
cd exchange-app

# Uygulamayı çalıştır
./mvnw spring-boot:run
```

## 🔗 API Endpoints

### 1. Döviz Çevirme
```
GET /api/exchange/convert?from=USD&to=TRY&amount=100
```

**Yanıt:**
```json
{
  "from": "USD",
  "to": "TRY",
  "amount": 100.0,
  "rate": 34.20,
  "result": 3420.0
}
```

### 2. Kurları Listele
```
GET /api/exchange/rates?base=USD
```

### 3. Desteklenen Para Birimleri
```
GET /api/exchange/currencies
```

## 📌 Notlar

- API key gerektirmez
- Ücretsiz ExchangeRate-API kullanır
- Günlük kur güncellemesi