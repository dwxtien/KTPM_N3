using BaiTap.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Xml.Linq;

namespace BaiTap.Controllers
{
    public class QuanLySanPhamController : Controller
    {
        // GET: QuanLySanPham
        private Model1 db = new Model1();
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult SanPham()
        {
            List<SanPham> ds = db.SanPhams.ToList();
            return View(ds);
        }
        public ActionResult DSChiTiet()
        {
            List<ChiTietSanPham> ds = db.ChiTietSanPhams.ToList();
            return View(ds);
        }
        [HttpGet]
        public ActionResult ThemSanPham()
        {
            return View();
        }
        [HttpPost]
        public ActionResult ThemSanPham(SanPham sp)
        {
            if(string.IsNullOrEmpty(sp.TenSanPham))
            {
                ModelState.AddModelError("", "Ten san pham khong duoc de trong");
            }
            if(sp.Gia < 0)
            {
                ModelState.AddModelError("", "Gia san pham khong duoc nho hon 0");
            }
            if(sp.Soluong < 0)
            {
                ModelState.AddModelError("", "So luong phai lon hon 0");
            }
            db.SanPhams.Add(sp);
            db.SaveChanges();
            return View("ThemChiTiet", new {id = sp.SanPhamID});
        }
        [HttpGet]
        public ActionResult ThemChiTiet(int id)
        {
            var sp = db.SanPhams.Find(id);
            if(sp == null)
            {
                return HttpNotFound();
            }
            ViewBag.SanPhan = sp;
            return View(new ChiTietSanPham { SanPhamID = sp.SanPhamID});
        }
        [HttpPost]
        public ActionResult ThemChiTiet(ChiTietSanPham chitiet)
        {
            using (var transaction = db.Database.BeginTransaction())
            {
                try { 
                var sp = db.SanPhams.Find(chitiet.SanPhamID);
                if (sp == null)
                {
                    ModelState.AddModelError("", "that bai");
                    return View(chitiet);
                }
                db.ChiTietSanPhams.Add(chitiet);
                db.SaveChanges();
                transaction.Commit();
                return View("danhsach");
                } catch (Exception ex)
                {
                    transaction.Rollback();
                    ModelState.AddModelError("", "Có lỗi xảy ra: " + ex.Message);
                    return View(chitiet);
                }
            }

        }
        public ActionResult Sua(int id)
        {
            var sp = db.SanPhams.Find(id);
            return View(sp);
        }
        [HttpPost]
        public ActionResult Sua(SanPham sanpham)
        {
            if(string.IsNullOrEmpty(sanpham.TenSanPham)==true)
            {
                ModelState.AddModelError("", "Ten sna pham ko dc d trong");
                return View(sanpham);
            }
            if(sanpham.Soluong < 0)
            {
                ModelState.AddModelError("", "So luong ko nho hon 0");
                return View(sanpham);
            }
            if(sanpham.Gia < 0)
            {
                ModelState.AddModelError("", "gia ko nho hon 0");
                return View(sanpham);

            }
            var update = db.SanPhams.Find(sanpham.SanPhamID);
            update.TenSanPham = sanpham.TenSanPham;
            update.Soluong = sanpham.Soluong;   
            update.MoTa = sanpham.MoTa;
            update.HangID = sanpham.HangID;
            update.DanhMucID = sanpham.DanhMucID;
            update.HinhAnh = sanpham.HinhAnh;
            update.SanPhamKhuyenMais = sanpham.SanPhamKhuyenMais;
            var id = db.SaveChanges();
            if(id > 0)
            {
                return RedirectToAction("SanPham");
            }
            else
            {
                ModelState.AddModelError("", "thay doi thong tin san pham that bai ");
                return View(db);
            }


        }
        public ActionResult Xoa()
        {
            return View();
        }
        
        //public ActionResult DSChiTiet(int id)
        //{
        //    var sanpham = db.SanPham.Include("ChiTietSanPham").FirstOrDefault(sp => sp.SanPhamID == id);
        //    return PartialView("DSChiTiet",sanpham);
            
        //}

    }
}