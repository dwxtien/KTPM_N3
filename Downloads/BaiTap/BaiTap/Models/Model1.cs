using System;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Linq;

namespace BaiTap.Models
{
    public partial class Model1 : DbContext
    {
        public Model1()
            : base("name=Model12")
        {
        }

        public virtual DbSet<Admin> Admins { get; set; }
        public virtual DbSet<BaoCao> BaoCaos { get; set; }
        public virtual DbSet<ChiTietDonHang> ChiTietDonHangs { get; set; }
        public virtual DbSet<ChiTietSanPham> ChiTietSanPhams { get; set; }
        public virtual DbSet<DanhMuc> DanhMucs { get; set; }
        public virtual DbSet<DonHang> DonHangs { get; set; }
        public virtual DbSet<Hang> Hangs { get; set; }
        public virtual DbSet<KhachHang> KhachHangs { get; set; }
        public virtual DbSet<KhuyenMai> KhuyenMais { get; set; }
        public virtual DbSet<LichSuDonHang> LichSuDonHangs { get; set; }
        public virtual DbSet<SanPham> SanPhams { get; set; }
        public virtual DbSet<SanPhamKhuyenMai> SanPhamKhuyenMais { get; set; }
        public virtual DbSet<Sosanh> Sosanhs { get; set; }
        public virtual DbSet<TonKho> TonKhoes { get; set; }
        public virtual DbSet<account_admin> account_admin { get; set; }
        public virtual DbSet<account_user> account_user { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Admin>()
                .Property(e => e.username)
                .IsUnicode(false);

            modelBuilder.Entity<Admin>()
                .Property(e => e.password)
                .IsUnicode(false);

            modelBuilder.Entity<Admin>()
                .Property(e => e.full_name)
                .IsUnicode(false);

            modelBuilder.Entity<Admin>()
                .Property(e => e.email)
                .IsUnicode(false);

            modelBuilder.Entity<Admin>()
                .Property(e => e.role)
                .IsUnicode(false);

            modelBuilder.Entity<Admin>()
                .Property(e => e.status)
                .IsUnicode(false);

            modelBuilder.Entity<KhuyenMai>()
                .Property(e => e.TenKhuyenMai)
                .IsUnicode(false);

            modelBuilder.Entity<KhuyenMai>()
                .Property(e => e.Mota)
                .IsUnicode(false);

            modelBuilder.Entity<KhuyenMai>()
                .Property(e => e.LoaiKM)
                .IsUnicode(false);

            modelBuilder.Entity<KhuyenMai>()
                .Property(e => e.DieuKien)
                .IsUnicode(false);

            modelBuilder.Entity<SanPham>()
                .HasMany(e => e.Sosanhs)
                .WithOptional(e => e.SanPham)
                .HasForeignKey(e => e.SPID1);

            modelBuilder.Entity<SanPham>()
                .HasMany(e => e.Sosanhs1)
                .WithOptional(e => e.SanPham1)
                .HasForeignKey(e => e.SPID2);

            modelBuilder.Entity<account_admin>()
                .Property(e => e.adminName)
                .IsFixedLength();

            modelBuilder.Entity<account_admin>()
                .Property(e => e.password)
                .IsFixedLength();

            modelBuilder.Entity<account_user>()
                .Property(e => e.username)
                .IsFixedLength();

            modelBuilder.Entity<account_user>()
                .Property(e => e.password)
                .IsFixedLength();

            modelBuilder.Entity<account_user>()
                .Property(e => e.fullName)
                .IsFixedLength();
        }
    }
}
