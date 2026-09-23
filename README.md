# Sistem Manajemen Robot Taman Dinosaurus (Versi UTS)

Aplikasi Java berbasis console yang mensimulasikan sistem manajemen robot dinosaurus di sebuah taman hiburan. Proyek ini merupakan **pengembangan dari tugas individu sebelumnya** (Tugas Individu PBO - Robot Dinosaurus) yang dikembangkan lebih lanjut untuk memenuhi **Ujian Tengah Semester (UTS) mata kuliah Pemrograman Berorientasi Objek (PBO)**.

## Identitas Mahasiswa
**Nama**        : Brendhen Canafaro Lie

**NIM**         : 2509116033

**Mata Kuliah** : Pemrograman Berorientasi Objek (PBO)

**Keterangan**  : Program dikembangkan dari tugas individu sebelumnya sesuai izin dosen pengampu.

---

## 1. Deskripsi Proyek

Studi kasus yang dipilih adalah **sistem manajemen robot dinosaurus di sebuah taman hiburan**. Setiap robot dinosaurus disimulasikan memiliki perilaku makan dan bersuara yang berbeda-beda tergantung kategorinya. Program berjalan lewat menu interaktif di console dan memungkinkan pengelola taman untuk:

- Mendaftarkan robot dinosaurus baru ke sistem, dikategorikan sebagai **Karnivora**, **Herbivora**, atau **Omnivora**
- Menampilkan seluruh daftar robot dinosaurus, dalam mode **ringkas** maupun **lengkap**
- Mensimulasikan pemberian makan (termasuk opsi menu makan tambahan) dan uji suara pada tiap robot
- Menjalankan aksi khusus yang hanya dimiliki jenis dinosaurus tertentu (berburu, menggembala, berkamuflase)
- Menghapus robot dinosaurus dari sistem

Studi kasus ini dipilih karena secara natural memetakan konsep dasar OOP: seluruh jenis dinosaurus berbagi atribut dan perilaku dasar yang sama (id, nama, era hidup, makan, bersuara), namun setiap jenis punya cara makan, suara, dan aksi khusus yang berbeda — sehingga cocok diimplementasikan lewat class induk (superclass) dan subclass yang saling meng-override method, ditambah beberapa method yang di-overload untuk kebutuhan baru.

### Pengembangan yang dilakukan untuk UTS

Dibanding versi tugas sebelumnya, ditambahkan:

1. **Method Overloading** pada class `Dinosaurus` (superclass):
   - `makan()` vs `makan(String menuTambahan)` — memberi opsi menu makan ekstra.
   - `tampilkanInfo()` vs `tampilkanInfo(boolean ringkas)` — memilih tampilan ringkas 1 baris atau detail lengkap.
2. Menu "Tambah Menu Ekstra" saat memberi makan robot, sebagai contoh nyata pemakaian overloading di alur program.
3. Menu "Tampilkan Semua Robot Dinosaurus" kini bisa dipilih dalam mode ringkas maupun lengkap, sebagai contoh nyata pemakaian overloading yang lain.

### Elemen Wajib OOP yang Diterapkan

| Elemen | Implementasi |
|---|---|
| **Inheritance** (≥ 2 tipe) | `Karnivora`, `Herbivora`, `Omnivora` seluruhnya `extends Dinosaurus` (3 tipe subclass) |
| **Polymorphism - Overriding** | `makan()`, `bersuara()`, `tampilkanInfo()` di-override di setiap subclass |
| **Polymorphism - Overloading** | `makan()` / `makan(String)` dan `tampilkanInfo()` / `tampilkanInfo(boolean)` di class `Dinosaurus` |
| **Condition (if-else)** | Validasi kategori saat tambah data, validasi pilihan menu, pengecekan `instanceof` di aksi khusus, dsb |
| **Looping** | `while` untuk menu utama, `for` untuk menampilkan daftar robot (mode ringkas & lengkap) |

---

## 2. Alur Program

### Hierarki Class

```
                Dinosaurus (superclass)
                /       |        \
        Karnivora   Herbivora   Omnivora
```

`Karnivora`, `Herbivora`, dan `Omnivora` merupakan subclass dari `Dinosaurus`. Ketiganya mewarisi atribut `id`, `nama`, `spesies`, dan `eraHidup`, lalu menambahkan atribut khusus masing-masing serta meng-override method `makan()`, `bersuara()`, dan `tampilkanInfo()`.

### Cara Menjalankan

1. Clone repository ini
   ```bash
   git clone <url-repo-kamu>
   ```
2. Buka project menggunakan Apache NetBeans / IntelliJ / VS Code (atau IDE Java lain yang mendukung Maven)
3. Pastikan **Main Class** project mengarah ke `com.mycompany.tugasindividu_pbo.Main`
4. Jalankan project (Run)
5. Ikuti menu interaktif yang muncul di console

Atau lewat terminal (tanpa IDE), dari folder project:
```bash
javac -d out $(find src -name "*.java")
java -cp out com.mycompany.tugasindividu_pbo.Main
```

### Cara Kerja Sistem

Saat program dijalankan, sistem otomatis memuat 3 data awal (1 Karnivora, 1 Herbivora, 1 Omnivora) ke dalam sebuah `ArrayList<Dinosaurus>`. Selanjutnya, menu utama akan terus muncul berulang (looping `while`) sampai pengguna memilih menu **0** untuk keluar.

| Menu | Fungsi | Konsep OOP yang dipakai |
|---|---|---|
| 1 | Tambah robot dinosaurus baru (pilih kategori Karnivora/Herbivora/Omnivora) | Condition (if-else), Inheritance |
| 2 | Tampilkan semua robot, pilih mode ringkas / lengkap | **Overloading**, Looping, Condition |
| 3 | Simulasi beri makan + opsi tambah menu ekstra | **Overriding + Overloading**, Condition |
| 4 | Uji suara robot | Overriding |
| 5 | Jalankan aksi khusus sesuai jenis (berburu/menggembala/berkamuflase) | Condition (`instanceof`), Polymorphism |
| 6 | Hapus robot dari sistem | Looping, Condition |
| 0 | Keluar program | - |

Objek-objek `Karnivora`, `Herbivora`, dan `Omnivora` disimpan bersama dalam satu `ArrayList<Dinosaurus>`. Saat method seperti `makan()` atau `bersuara()` dipanggil lewat referensi `Dinosaurus`, Java otomatis menjalankan versi override milik objek aslinya (dynamic method dispatch) — inilah penerapan **polymorphism** di program ini.

---

## 3. Penjelasan Gambar (Screenshot Output Program)

> Ganti tautan gambar di bawah ini dengan screenshot hasil run program kamu sendiri (drag & drop gambar ke kolom komentar Issue/PR di GitHub untuk mendapatkan link, seperti pada README tugas sebelumnya, lalu tempel di sini).

### Menu Utama

*(tempel screenshot menu utama di sini)*

Menampilkan seluruh pilihan menu 0-6.

### Tambah Robot Dinosaurus Baru

*(tempel screenshot menu 1 di sini)*

Menunjukkan proses input kategori dan data robot baru, lalu robot berhasil ditambahkan ke `ArrayList`.

### Tampilkan Daftar Robot (Mode Ringkas & Lengkap)

*(tempel screenshot menu 2 - mode ringkas di sini)*

*(tempel screenshot menu 2 - mode lengkap di sini)*

Membuktikan **method overloading** `tampilkanInfo()` (lengkap) dan `tampilkanInfo(boolean)` (ringkas) menghasilkan output berbeda sesuai parameter yang dikirim.

### Simulasi Beri Makan (dengan Menu Ekstra)

*(tempel screenshot menu 3 di sini)*

Membuktikan **method overriding** (`makan()` berbeda tiap kategori dinosaurus) sekaligus **method overloading** (`makan(String menuTambahan)` saat memilih menambah menu ekstra).

### Uji Suara Robot

*(tempel screenshot menu 4 di sini)*

### Aksi Khusus per Jenis Dinosaurus

*(tempel screenshot menu 5 - Karnivora/Herbivora/Omnivora di sini)*

### Hapus Robot Dinosaurus

*(tempel screenshot menu 6 di sini)*

---

## Struktur Project

```
src/main/java/com/mycompany/tugasindividu_pbo/
├── Dinosaurus.java   (superclass, termasuk method overloading)
├── Karnivora.java    (subclass)
├── Herbivora.java    (subclass)
├── Omnivora.java     (subclass)
└── Main.java         (menu interaktif & logika program)
```
