package ac.id.atmaluhur.mhs.arfies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DosenPost {
    @SerializedName("nidn")
    @Expose
    private String nidn;
    @SerializedName("nama_dosen")
    @Expose
    private String nama_dosen;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("gol_pang")
    @Expose
    private String gol_pang;
    @SerializedName("keahlian")
    @Expose
    private String keahlian;
    @SerializedName("program_studi")
    @Expose
    private String program_studi;

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getNama_dosen() {
        return nama_dosen;
    }

    public void setNama_dosen(String nama_dosen) {
        this.nama_dosen = nama_dosen;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getGol_pang() {
        return gol_pang;
    }

    public void setGol_pang(String gol_pang) {
        this.gol_pang = gol_pang;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public String getProgram_studi() {
        return program_studi;
    }

    public void setProgram_studi(String program_studi) {
        this.program_studi = program_studi;
    }
}
