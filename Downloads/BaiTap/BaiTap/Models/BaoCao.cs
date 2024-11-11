namespace BaiTap.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("BaoCao")]
    public partial class BaoCao
    {
        [Key]
        public int BCID { get; set; }

        [Column(TypeName = "date")]
        public DateTime? NgayBaoCao { get; set; }

        public double DanhSo { get; set; }

        public int TongDonHang { get; set; }

        [Column(TypeName = "date")]
        public DateTime? NgayCapNhatCC { get; set; }
    }
}
