# Sistem Manajemen Robot Taman Dinosaurus 

Aplikasi Java berbasis console yang mensimulasikan sistem manajemen robot dinosaurus di sebuah taman hiburan. Proyek ini merupakan **pengembangan dari tugas individu sebelumnya** (Tugas Individu PBO - Robot Dinosaurus) yang dikembangkan lebih lanjut untuk memenuhi **Ujian Tengah Semester (UTS) mata kuliah Pemrograman Berorientasi Objek (PBO)**.

## Identitas Mahasiswa
**Nama**        : Brendhen Canafaro Lie

**NIM**         : 2509116033

**Mata Kuliah** : Pemrograman Berorientasi Objek (PBO)

---

## Struktur Project


<img width="281" height="222" alt="image" src="https://github.com/user-attachments/assets/9e515def-a394-47c2-afc6-64ebb2d51f67" />


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


<img width="1127" height="1536" alt="image" src="https://github.com/user-attachments/assets/a91c236a-484f-4c92-b463-eebb9184638f" />


`Karnivora`, `Herbivora`, dan `Omnivora` merupakan subclass dari `Dinosaurus`. Ketiganya mewarisi atribut `id`, `nama`, `spesies`, dan `eraHidup`, lalu menambahkan atribut khusus masing-masing serta meng-override method `makan()`, `bersuara()`, dan `tampilkanInfo()`.


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


### Menu Utama


<img width="313" height="213" alt="image" src="https://github.com/user-attachments/assets/0bafa011-64dc-4dcb-98a1-bb58f0582671" />


Menampilkan seluruh pilihan menu 0-6.

### Tambah Robot Dinosaurus Baru


<img width="464" height="214" alt="image" src="https://github.com/user-attachments/assets/af3083c5-97cb-4a2f-8c32-b06d8d4a82ec" />


Menunjukkan proses input kategori dan data robot baru, lalu robot berhasil ditambahkan ke `ArrayList`.

### Tampilkan Daftar Robot (Mode Ringkas & Lengkap)


<img width="454" height="137" alt="image" src="https://github.com/user-attachments/assets/3baba33a-776c-43cd-a417-e2253b72a982" />


<img width="319" height="419" alt="image" src="https://github.com/user-attachments/assets/7b6906bb-5552-43f8-b746-291fa71837cb" />


Membuktikan **method overloading** `tampilkanInfo()` (lengkap) dan `tampilkanInfo(boolean)` (ringkas) menghasilkan output berbeda sesuai parameter yang dikirim.

### Simulasi Beri Makan (dengan Menu Ekstra)


<img width="519" height="255" alt="image" src="https://github.com/user-attachments/assets/27286774-f089-4b6a-83aa-4b66a106e1a1" />


Membuktikan **method overriding** (`makan()` berbeda tiap kategori dinosaurus) sekaligus **method overloading** (`makan(String menuTambahan)` saat memilih menambah menu ekstra).

### Uji Suara Robot


<img width="684" height="59" alt="image" src="https://github.com/user-attachments/assets/47d11af6-0d5d-4880-9458-0abaf808a246" />


### Aksi Khusus per Jenis Dinosaurus


<img width="707" height="61" alt="image" src="https://github.com/user-attachments/assets/8d14af0f-5584-4b5d-9c54-307a5fa94762" />


### Hapus Robot Dinosaurus


<img width="429" height="199" alt="image" src="https://github.com/user-attachments/assets/a938fca9-117f-4a4b-be0e-36c7e6ed5c3d" />



