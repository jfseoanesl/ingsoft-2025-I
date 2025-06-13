# 🧩 Sistema de Pagos con Patrón de Diseño Bridge

Este proyecto demuestra cómo aplicar el **patrón de diseño estructural Bridge** en una arquitectura típica de Spring Boot, separando la abstracción de los tipos de pagos de la implementación concreta de los procesadores de pago.

---

## 🧠 Propósito

El patrón **Bridge** se aplica aquí para permitir la evolución independiente de las clases de pagos (Simple, Cuotas, Recurrente) y los procesadores (Stripe, MercadoPago, PayPal, etc.), sin multiplicar innecesariamente combinaciones de clases ni acoplar jerarquías.

---

## 📂 Estructura del Proyecto


---

## ⚙️ Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Maven
- Lombok (opcional)
- JUnit 5

---

## 🧠 ¿Por qué Bridge?

Sin el patrón **Bridge**, tendrías que crear clases para cada combinación:

- `SimpleStripePayment`, `SimpleMercadoPagoPayment`, `InstallmentStripePayment`, etc.

Esto viola el principio de **cerrado/abierto**, genera una explosión de clases y aumenta el acoplamiento. Con Bridge:

- Las **abstracciones** (`Payment`) y **implementaciones** (`PaymentProcessor`) evolucionan de forma independiente.

---

## 🏁 Cómo ejecutar

### Prerrequisitos

- Java 17 o superior
- Maven 3.6 o superior

### Ejecutar aplicación


# Clonar y navegar al directorio
git clone https://github.com/tuusuario/payment-bridge-pattern.git
cd payment-bridge-pattern

# Compilar
mvn clean compile

# Ejecutar tests
mvn test

# Endpoint
Procesar Pago
POST /payment-system/api/payments/process
Content-Type: application/json

🧪 Ejemplos de petición
1. Pago simple con Stripe

```bash
# Ejecutar aplicación
mvn spring-boot:run
{
  "amount": 150.00,
  "currency": "USD",
  "description": "Compra de producto",
  "customerEmail": "cliente@email.com",
  "paymentType": "SIMPLE",
  "processor": "STRIPE"
}
```
2. Pago con cuotas usando MercadoPago
```bash
{
"amount": 1200.00,
"currency": "COP",
"description": "Compra a cuotas",
"customerEmail": "cliente@email.com",
"paymentType": "INSTALLMENT",
"processor": "MERCADOPAGO",
"installments": 6
}
```
3. Pago recurrente

```bash
{
  "amount": 50.00,
  "currency": "USD",
  "description": "Suscripción mensual",
  "customerEmail": "cliente@email.com",
  "paymentType": "RECURRING",
  "frequency":"MONTHLY"
}
```

# Ejemplos de Respuesta
Respuesta Exitosa
```bash
json{
"paymentId": "12345678-90ab-cdef-1234-567890abcdef",
"status": "SUCCESS",
"amount": 150.00,
"currency": "USD",
"processor": "Stripe",
"message": "Pago procesado exitosamente",
"processedAt": "2025-06-09T10:30:00"
}
```
Respuesta con error

```bash
json{
"paymentId": null,
"status": "ERROR",
"amount": 50.00,
"currency": "EUR",
"processor": "MercadoPago",
"message": "Moneda no soportada por este procesador",
"processedAt": "2025-06-09T10:35:00"
}
```
# ✅ Ventajas del uso de Bridge
Independencia entre abstracción y la implementación.

Facilita la adición de nuevos tipos de pagos o nuevos procesadores.

Reducción de la duplicación de código.

Facilita pruebas unitarias al separar responsabilidades.

# ⚠️ Posibles desventajas
Puede agregar más complejidad inicial si el problema no justifica la abstracción.

La solución puede ser excesiva para casos simples donde una jerarquía plana sea suficiente.

