namespace BaiTap.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("KhuyenMai")]
    public partial class KhuyenMai
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public KhuyenMai()
        {
            SanPhamKhuyenMais = new HashSet<SanPhamKhuyenMai>();
        }

        public int KhuyenMaiID { get; set; }

        [Required]
        [StringLength(100)]
        public string TenKhuyenMai { get; set; }

        [Column(TypeName = "text")]
        public string Mota { get; set; }

        [Column(TypeName = "date")]
        public DateTime NgayBD { get; set; }

        [Column(TypeName = "date")]
        public DateTime NgayKT { get; set; }

        [Required]
        [StringLength(50)]
        public string LoaiKM { get; set; }

        [Column(TypeName = "text")]
        public string DieuKien { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<SanPhamKhuyenMai> SanPhamKhuyenMais { get; set; }
    }
}
