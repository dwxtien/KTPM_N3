using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BaiTap.Models
{
    public class PhieuNhapKhoViewModel
    {
        public int ? SanPhamID { get; set; }
        public int soluong {  get; set; }
        public double Gia {  get; set; }
        public SanPham SanPham { get; set; }
        public ChiTietSanPham ChiTietSanPham { get; set; }
        public TonKho TonKho { get; set; }
        public string DanhMucMoi {  get; set; }
        public string HangsxMoi {  get; set; }
    }

}