

package com.mycompany.Tugas_UTS_PBO;


// ============================================================================
// SUPER CLASS: Dinosaurus
// ============================================================================

public class Dinosaurus {
    //ATRIBUT
    private String id;
    private String nama;
    private String spesies; // Jenis Pemakan Contohnya Karnivora, Herbivora, Omnivora
    private String eraHidup; // Era hidup PreHistoric Contohnya Zaman Kapur, Ice age
    
    //CONSTRUCT
    public Dinosaurus(String id, String nama, String spesies, String eraHidup){
        this.id = id;
        this.nama = nama;
        this.spesies = spesies;
        this.eraHidup = eraHidup;
    }
    
    //GETTER
    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public String getSpesies() {
        return spesies;
    }
    public String getEraHidup() {
        return eraHidup;
    }
    
    
    //METHOD
    public void makan() {
        System.out.println("Robot " + nama + " (" + spesies + ") sedang memproses pakan simulasi.");
    }

    // METHOD OVERLOADING: nama method sama (makan), parameter berbeda
    // dipakai ketika pengelola taman ingin menambahkan menu ekstra di luar pakan utama
    public void makan(String menuTambahan) {
        System.out.println("Robot " + nama + " memproses pakan simulasi tambahan: " + menuTambahan + ".");
    }
    
    public void bersuara() {
        System.out.println("Robot " + nama + " mengeluarkan suara sintetis dinosaurus umum.");
    }
    
    public void tampilkanInfo() {
        System.out.println("ID               : " + id);
        System.out.println("Nama             : " + nama);
        System.out.println("Spesies          : " + spesies);
        System.out.println("Era Prasejarah   : " + eraHidup);
    }

    // METHOD OVERLOADING: nama method sama (tampilkanInfo), parameter berbeda
    // ringkas = true  -> tampil 1 baris singkat
    // ringkas = false -> tampil detail lengkap (pakai method tampilkanInfo() di atas)
    public void tampilkanInfo(boolean ringkas) {
        if (ringkas) {
            System.out.println(id + " | " + nama + " | " + spesies + " | " + eraHidup);
        } else {
            tampilkanInfo();
        }
    }
}
