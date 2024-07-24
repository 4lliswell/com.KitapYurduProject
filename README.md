# Kitapyurdu Web Sitesi Selenium TestNG Otomasyon Testi

Bu proje, Selenium ve TestNG kullanılarak Kitapyurdu sitesi üzerinde otomasyon testleri yapmak amacıyla geliştirilmiştir.

## Proje Amaçları

- Kitapyurdu sitesini açarak ürün aratmak.
- Arama sonuçlarını kontrol etmek.
- Ürün sepete eklemek ve sepet aksiyonları.

## Gereksinimler

- Java 8 veya üstü
- Selenium WebDriver
- TestNG
- Log4j
- Maven (proje bağımlılıklarını yönetmek için)
- Allure-Report (raporlama için)

## Kurulum

1. **Projeyi İndirin:**

   ```bash
   git clone https://github.com/kullanici/proje-adı.git
   cd proje-adı
   ```

2. **Bağımlılıkları Yükleyin:**

   
   pom.xml
   

## Nasıl Kullanılır

Proje bağımlılıkları yüklendikten sonra, testleri aşağıdaki komutla çalıştırabilirsiniz:

```bash
mvn test
```

## Kullanılan Teknolojiler

- Selenium WebDriver: Web uygulaması otomasyonu için kullanılır.
- TestNG: Test senaryolarının organize edilmesi ve yönetilmesi için kullanılır.
- Log4j: Loglama için kullanılır.
- Allure-Report: Güzel ve detaylı raporlama için kullanılır.

## Proje Yapısı

Proje, aşağıdaki dizin yapısına sahiptir:

- `src/test/java`: Test kodları
  - `pages`: Sayfa objeleri için sınıflar
  - `tests`: Test senaryoları
  - `utilities`: Yardımcı sınıflar (Log4j vb.)

## Senaryo Adımları ve Kod Örnekleri

Proje içerisinde yer alan senaryolar aşağıda yer almaktadır:

1. **Kitapyurdu sitesi açılır ve ana sayfa doğruluğu kontrol edilir:**

2. **Çerez tercihlerinden kabul seçeneği işaretlenir ve devam edilir:**

3. **Ürün arama satırına "roman" yazdırılır ve aratılır, sonuçların "roman" içerdiği kontrol edilir:**

4. **2. sayfaya geçiş yapılır ve geçişin doğruluğu kontrol edilir:**

5. **Listelenen kitaplardan birine tıklanır ve sepete ekle butonuna tıklanarak eklemenin doğruluğu kontrol edilir:**

6. **Sepetim butonuna tıklanır, ürün miktarı artırılır ve güncellemenin doğruluğu kontrol edilir:**

7. **Ürün sepetten silinir ve sepetin boş olduğu kontrol edilir:**


## Notlar

- Test senaryoları TestNG-POM kullanılarak yönetilmektedir.
- Raporlama için Allure-Report kullanılmaktadır.
- Loglama işlemleri Log4j kullanılarak yapılmaktadır.
