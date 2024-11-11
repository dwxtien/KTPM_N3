namespace BaiTap.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("ChiTietSanPham")]
    public partial class ChiTietSanPham
    {
        public int ChiTietSanPhamID { get; set; }

        public int? SanPhamID { get; set; }

        [StringLength(100)]
        public string ManHinh { get; set; }

        [StringLength(100)]
        public string HeDieuHanh { get; set; }

        [StringLength(100)]
        public string CameraTruoc { get; set; }

        [StringLength(100)]
        public string CameraSau { get; set; }

        [StringLength(100)]
        public string Chip { get; set; }

        [StringLength(100)]
        public string RAM { get; set; }

        [StringLength(100)]
        public string BoNhoTrong { get; set; }

        [StringLength(100)]
        public string Sim { get; set; }

        [StringLength(100)]
        public string Pin { get; set; }

        public virtual SanPham SanPham { get; set; }
    }
}
