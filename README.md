# 📚 Kitap Takip Uygulaması (Library Management API)

Bu proje, bir kütüphane veya kitap takip sistemi için geliştirilmiş bir **Spring Boot REST API** uygulamasıdır. Kullanıcılar (üyeler), kitaplar ve ödünç alma işlemleri yönetilebilir.

## 🚀 Teknolojiler
- **Java 21**
- **Spring Boot 3.x** (Web, Data JPA)
- **PostgreSQL** (Veritabanı)
- **Lombok** (Boilerplate kodları azaltmak için)
- **Maven** (Bağımlılık yönetimi)

## 🔗 API Uç Noktaları (Endpoints)

### Kitap Yönetimi (`/api/books`)
| Metot | Endpoint | Açıklama |
|---|---|---|
| `GET` | `/api/books` | Tüm kitapları listeler |
| `GET` | `/api/books/{id}` | Belirli bir kitabı getirir |
| `POST` | `/api/books` | Yeni kitap ekler |
| `PUT` | `/api/books/{id}` | Kitap bilgilerini günceller |
| `DELETE` | `/api/books/{id}` | Kitabı siler |

### Üye Yönetimi (`/api/members`)
| Metot | Endpoint | Açıklama |
|---|---|---|
| `GET` | `/api/members` | Tüm üyeleri listeler |
| `GET` | `/api/members/{id}` | Belirli bir üyeyi getirir |
| `GET` | `/api/members/{id}/books` | Üyenin aktif olarak ödünç aldığı kitapları listeler |
| `POST` | `/api/members` | Yeni üye ekler |
| `PUT` | `/api/members/{id}` | Üye bilgilerini günceller |
| `DELETE` | `/api/members/{id}` | Üyeyi siler |

### Ödünç Alma (Loan) Yönetimi (`/api/loans`)
| Metot | Endpoint | Açıklama |
|---|---|---|
| `GET` | `/api/loans` | Tüm ödünç işlemlerini listeler |
| `POST` | `/api/loans/{bookId}/{memberId}` | Üyeye kitap ödünç verir |
| `PATCH` | `/api/loans/{loanId}/return` | Ödünç alınan kitabı iade alır |

## 🏗️ Mimari Yapı
Proje standart **Katmanlı Mimari** (Layered Architecture) prensiplerine göre tasarlanmıştır:
- **Controller**: Dışarıdan gelen HTTP isteklerini (REST) karşılar ve yanıt döner.
- **Service**: İş mantığının (business logic) yürütüldüğü, kuralların işletildiği katmandır.
- **Repository**: Veritabanı işlemleri için kullanılan Spring Data JPA arayüzleridir.
- **Entity**: Veritabanındaki tabloları temsil eden Java sınıflarıdır.

---
**Not:** Bu proje geliştirilmeye ve yeni özellikler eklenmeye açıktır.
